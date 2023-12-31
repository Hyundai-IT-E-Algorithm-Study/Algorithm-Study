-- 코드를 입력하세요
SELECT A.CAR_ID, A.CAR_TYPE, ROUND(A.DAILY_FEE*30*(100-DISCOUNT_RATE)/100, 0) AS FEE
FROM
(SELECT *
FROM CAR_RENTAL_COMPANY_CAR 
WHERE CAR_TYPE IN ('SUV', '세단')
AND CAR_ID NOT IN
(SELECT CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
WHERE START_DATE <= TO_DATE('2022-11-30', 'YYYY-MM-DD') AND
END_DATE >= TO_DATE('2022-11-01', 'YYYY-MM-DD'))) A
LEFT OUTER JOIN (SELECT CAR_TYPE, DISCOUNT_RATE
                 FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
                 WHERE DURATION_TYPE='30일 이상') B
ON A.CAR_TYPE = B.CAR_TYPE
WHERE ROUND(A.DAILY_FEE*30*(100-DISCOUNT_RATE)/100, 0) BETWEEN 500000 AND 2000001
ORDER BY FEE DESC, A.CAR_TYPE, A.CAR_ID DESC
;
