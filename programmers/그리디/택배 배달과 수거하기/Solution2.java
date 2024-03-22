public long solution2(int cap, int n, int[] deliveries, int[] pickups) {
        StackInteger dS = new Stack();
        StackInteger pS = new Stack();
        long answer = 0;
        
        for(int i = 0; i  n; i++) {
            if (deliveries[i] != 0) {
                dS.push(i);
            }
            if (pickups[i] != 0) {
                pS.push(i);
            }
        }
        
        while(!dS.empty()  !pS.empty()) {
            final int dLen = !dS.empty()  dS.peek() + 1  0;
            final int pLen = !pS.empty()  pS.peek() + 1 0;
            answer += Math.max(dLen, pLen)  2;
            
            int dC = cap;
            int pC = cap;
            
            while(!dS.empty()) {
                final int dIdx = dS.pop();
                final int d = deliveries[dIdx];
                final int calcD = dC - d;
                if (calcD  0) {
                    dC -= d;
                    continue;
                } else if (calcD == 0) {
                    break;
                }
                
                deliveries[dIdx] -= dC;
                dS.push(dIdx);
                break;
            }
            
             while(!pS.empty()) {
                final int pIdx = pS.pop();
                final int p = pickups[pIdx];
                final int calcP = pC - p;
                if (calcP  0) {
                    pC -= p;
                    continue;
                } else if (calcP == 0) {
                    break;
                }
                
                pickups[pIdx] -= pC;
                pS.push(pIdx);
                break;
            }
        }
        
        return answer;
    }