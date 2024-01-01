--mysql

SELECT C.CAR_ID, C.CAR_TYPE, FLOOR(C.DAILY_FEE * 30 * (1 - P.DISCOUNT_RATE/100)) AS FEE
FROM CAR_RENTAL_COMPANY_CAR C
INNER JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P ON C.CAR_TYPE = P.CAR_TYPE AND P.DURATION_TYPE = '30일 이상'
LEFT OUTER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H ON C.CAR_ID = H.CAR_ID 
AND ('2022-11-01' BETWEEN H.START_DATE AND H.END_DATE OR '2022-11-30' BETWEEN H.START_DATE AND H.END_DATE)
WHERE C.CAR_TYPE IN ('세단','SUV') AND H.CAR_ID IS NULL
AND FLOOR(C.DAILY_FEE * 30 * (1 - P.DISCOUNT_RATE/100)) BETWEEN 500000 AND 1999999
ORDER BY 3 DESC, 2 ASC, 1 DESC
