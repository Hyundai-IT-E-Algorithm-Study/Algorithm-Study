SELECT extract(month from start_date) as MONTH, car_id, count(history_id) as RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
WHERE car_id IN (SELECT c.car_id
                FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY c
                WHERE extract(month from c.start_date) between 8 and 10
                GROUP BY c.car_id
                HAVING count(c.history_id)>=5
                )  AND extract(month from start_date) between 8 and 10
GROUP BY extract(month from start_date), car_id
ORDER BY 1, 2 desc
