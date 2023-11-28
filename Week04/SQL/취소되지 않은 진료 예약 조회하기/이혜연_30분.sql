SELECT B.APNT_NO, A.PT_NAME, A.PT_NO, B.MCDP_CD, C.DR_NAME, B.APNT_YMD
FROM PATIENT A, APPOINTMENT B, DOCTOR C
WHERE A.PT_NO = B.PT_NO
AND C.DR_ID = B.MDDR_ID
AND B.MCDP_CD = 'CS'AND TO_CHAR(B.APNT_YMD, 'YYYY-MM-DD') = '2022-04-13'AND B.APNT_CNCL_YN = 'N'
ORDER BY B.APNT_YMD;
