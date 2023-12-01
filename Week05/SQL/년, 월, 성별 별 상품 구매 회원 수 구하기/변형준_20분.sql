SELECT EXTRACT(YEAR FROM s.sales_date) AS "YEAR"
     , EXTRACT(MONTH FROM s.sales_date) AS "MONTH"
     , u.gender AS "GENDER"
     , COUNT(DISTINCT(u.user_id)) as "USERS"
FROM user_info u
JOIN online_sale s ON u.user_id = s.user_id
WHERE gender IS NOT NULL
GROUP BY EXTRACT(YEAR FROM s.sales_date), EXTRACT(MONTH FROM s.sales_date), u.gender
ORDER BY 1, 2, 3;
