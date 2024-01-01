SELECT MEMBER_NAME, REVIEW_TEXT,TO_CHAR(REVIEW_DATE,'YYYY-MM-DD') REVIEW_DATE
FROM MEMBER_PROFILE A, REST_REVIEW B
WHERE 1=1
  AND A.MEMBER_ID = B.MEMBER_ID
  AND A.MEMBER_ID IN
                ( SELECT MEMBER_ID
                    FROM
                         (SELECT MEMBER_ID,COUNT(REVIEW_ID) 
                            FROM REST_REVIEW
                        GROUP BY MEMBER_ID
                        ORDER BY COUNT(REVIEW_ID) DESC)
                   WHERE ROWNUM <= 1
                )
ORDER BY 3, 2;
