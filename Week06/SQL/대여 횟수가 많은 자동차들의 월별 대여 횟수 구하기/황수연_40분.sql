SELECT extract(month from start_date) as month, car_id, count(car_id) as records
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE car_id in (
    select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where to_char(start_date,'yyyy-mm-dd') between '2022-08-01' and '2022-10-31'
    group by car_id
    having count(car_id) >= 5
) and to_char(start_date,'yyyy-mm-dd') between '2022-08-01' and '2022-10-31' // 이거 안해주니 계속 오류났음
GROUP BY extract(month from start_date), car_id
HAVING count(car_id) > 0
ORDER BY month asc, car_id desc;
