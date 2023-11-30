SELECT CAR_ID, CASE WHEN sum(CASE WHEN TO_DATE('2022-10-16', 'YYYY-MM-DD') - end_date  <= 0
                                  AND TO_DATE('2022-10-16', 'YYYY-MM-DD') - start_date >= 0 then 1 else 0 end) >= 1 then '대여중' 
                    ELSE '대여 가능' END as availability
FROM car_rental_company_rental_history
GROUP BY car_id
ORDER BY car_id desc;
