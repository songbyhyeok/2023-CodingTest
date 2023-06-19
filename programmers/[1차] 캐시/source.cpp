#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

void ConvertLower(string& name) {
	for (int i = 0; i < name.length(); i++) {
		if (!islower(name[i]))
			name[i] += 32;
	}
}

void ConvertUpper(string& name) {
	for (int i = 0; i < name.length(); i++) {
		if (!isupper(name[i]))
			name[i] -= 32;
	}
}

template <typename T>
class Node {
public:
	Node(T t) {
		data = move(t);
		previous = nullptr;
		next = nullptr;
	}

	T getData() const {
		return data;
	}

public:
	//friend class DoubleLinkedList;

	T data;
	Node* previous;
	Node* next;
};

template <typename T>
class DoubleLinkedList {
public:
	DoubleLinkedList() = default;

	// 몸통과 머리를 서로 엮는 초기화 작업
	void init(T headVal, T tailVal) {
		head = new Node<T>(move(headVal));
		tail = new Node<T>(move(tailVal));

		head->next = tail;
		tail->previous = head;
	}

	// 꼬리 이전 ~ 꼬리 사이에 새 노드를 집어넣는 연산 O(1)
	void insert(Node<T>* node) const {
		tail->previous->next = node;
		node->previous = tail->previous;

		node->next = tail;
		tail->previous = node;
	}

	// 해당 노드가 위치한 임의 위치에 노드를 빼내는 연산 O(1)
	void remove(Node<T>* node) const {
		node->previous->next = node->next;
		node->next->previous = node->previous;
	}

	// 연결된 모든 노드를 힙에 반환하는 작업
	void clear() const {
		Node<T>* curr = head;
		while (curr != nullptr) {
			Node<T>* next = curr->next;

			delete(curr);
			curr = nullptr;

			if (next == nullptr)
				break;

			curr = next;
		}
	}

	Node<T>* getFront() const {
		return head->next;
	}

	Node<T>* getBack() const {
		return tail->previous;
	}

private:
	Node<T>* head;
	Node<T>* tail;
};

template <typename T, typename T2>
class LRU {
public:
	LRU(int size, T headVal, T tailVal) {
		dList.init(move(headVal), move(tailVal));

		cacheSize = size;
		runningTime = 0;
	}

	void insert(T city) {
		// 빼는 연산 대문자 처리 방식보다 더하는 소문자 처리 방식이 더 빠르기 때문에 소문자 변환 함수 사용
		ConvertLower(city);

		// 검색 시
		if (uMap.find(city) != uMap.end()) {
			Node<T>* findNode = uMap[move(city)];
			dList.remove(findNode);
			dList.insert(findNode);

			// cache hit
			++runningTime;
		}
		// 검색이 안 된다면
		else {
			// 캐쉬 크기를 넘는다면
			if (cacheSize <= uMap.size()) {
				// 가장 오래된 첫 페이지를 제거
				uMap.erase(dList.getFront()->getData());
				dList.remove(dList.getFront());
			}

			// 새로운 페이지를 생성 후 LRU에 집어넣기
			Node<T>* nNode = new Node<T>(move(city));
			uMap.insert({ nNode->getData(), nNode });
			dList.insert(nNode);

			// cache miss
			runningTime += 5;
		}
	}

	int getRunningTime() const {
		return runningTime;
	}

	~LRU() {
		clear();
	}

private:
	void clear() {
		dList.clear();
		uMap.clear();
	}

private:
	unordered_map<T2, Node<T>*> uMap;
	DoubleLinkedList<T> dList;
	int cacheSize;
	int runningTime;
};

int solution(int cacheSize, vector<string> cities) {
	// 0이면 알고리즘이 작동할 이유가 없다.
	if (cacheSize == 0)
		return cities.size() * 5;

	LRU<string, string> lru(cacheSize, "Head", "Tail");
	for (const auto& city : cities)
		lru.insert(city);

	return lru.getRunningTime();
}

int main(void) {
	cout << solution(3, { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" }) << '\n';
	cout << solution(3, { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" }) << '\n';
	cout << solution(2, { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome" }) << '\n';
	cout << solution(5, { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome" }) << '\n';
	cout << solution(2, { "Jeju", "Pangyo", "NewYork", "newyork" }) << '\n';
	cout << solution(0, { "Jeju", "Pangyo", "Seoul", "NewYork", "LA" }) << '\n';
	cout << solution(0, { "LA", "LA" }) << '\n';

	return 0;
}