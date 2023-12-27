-- 코드를 입력하세요
SELECT (SELECT MEMBER_NAME
        FROM MEMBER_PROFILE
        WHERE MEMBER_ID = R.MEMBER_ID) MEMBER_NAME, REVIEW_TEXT, TO_CHAR(REVIEW_DATE, 'YYYY-MM-DD') REVIEW_DATE
FROM REST_REVIEW R
WHERE MEMBER_ID IN (SELECT MEMBER_ID
                    FROM REST_REVIEW
                    GROUP BY MEMBER_ID
                    HAVING COUNT(*) = (SELECT MAX(REVIEWCOUNT)
                                        FROM (SELECT MEMBER_ID, COUNT(*) REVIEWCOUNT
                                              FROM REST_REVIEW
                                              GROUP BY MEMBER_ID)))
ORDER BY REVIEW_DATE, REVIEW_TEXT
