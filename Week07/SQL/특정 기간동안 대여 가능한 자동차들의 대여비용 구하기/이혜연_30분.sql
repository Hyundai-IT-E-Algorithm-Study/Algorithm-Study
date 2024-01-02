SELECT c.car_id, c.car_type, round(c.daily_fee*30 - c.daily_fee*30*(p.discount_rate/100)) as fee
FROM car_rental_company_car c, car_rental_company_rental_history h,
     car_rental_company_discount_plan p
WHERE c.car_id=h.car_id AND c.car_type=p.car_type
AND c.car_type IN ('세단','SUV')
AND c.car_id NOT IN (
                    SELECT CAR_ID
                    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                    WHERE to_char(start_date,'YYYY-MM-DD') BETWEEN '2022-11-01' AND '2022-11-30'
                    OR to_char(end_date,'YYYY-MM-DD') BETWEEN '2022-11-01' AND '2022-11-30'
                    OR (to_char(start_date,'YYYY-MM-DD') <= '2022-11-01' AND to_char(end_date,'YYYY-MM-DD') >= '2022-11-30'))
AND p.duration_type='30일 이상'
AND round(c.daily_fee*30 - c.daily_fee*30*(p.discount_rate/100)) between 500000 and 2000000
ORDER BY 3 desc, 2, 1 desc;
