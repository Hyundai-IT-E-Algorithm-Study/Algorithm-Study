-- 코드를 입력하세요
SELECT DISTINCT C.CAR_ID
FROM CAR_RENTAL_COMPANY_CAR C
INNER JOIN (SELECT CAR_ID
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
            WHERE TO_CHAR(START_DATE, 'MM') = 10) H
ON C.CAR_ID = H.CAR_ID
WHERE CAR_TYPE = '세단'
ORDER BY CAR_ID DESC
;
