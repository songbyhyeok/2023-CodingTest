SELECT A.APNT_NO, P.PT_NAME, A.PT_NO, A.MCDP_CD, D.DR_NAME, 
    A.APNT_YMD
FROM APPOINTMENT AS A
    JOIN ( 
        SELECT PT_NO, PT_NAME
        FROM PATIENT 
    ) AS P
        ON A.PT_NO = P.PT_NO
    JOIN (
        SELECT DR_NAME, DR_ID, MCDP_CD
        FROM DOCTOR 
    ) AS D
        ON A.MDDR_ID = D.DR_ID
WHERE APNT_CNCL_YN = 'N' AND 
    DATE_FORMAT(A.APNT_YMD, '%Y-%m-%d') = '2022-04-13'
ORDER BY APNT_YMD ASC