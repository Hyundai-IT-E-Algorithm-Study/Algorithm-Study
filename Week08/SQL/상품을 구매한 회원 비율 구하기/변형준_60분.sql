SELECT 
      TO_CHAR(sales_date, 'YYYY') YEAR
    , TO_NUMBER(TO_CHAR(sales_date, 'MM')) MONTH
    , COUNT(DISTINCT(user_id)) PUCHASED_USERS
    , ROUND(COUNT(DISTINCT(user_id)) / (SELECT COUNT(*) 
                                          FROM user_info 
                                         WHERE TO_CHAR(joined, 'YYYY') = '2021')
            , 1) AS PUCHASED_RATIO
FROM online_sale 
WHERE user_id IN (SELECT user_id
                    FROM user_info
                   WHERE TO_CHAR(joined, 'YYYY') = '2021')
GROUP BY TO_CHAR(sales_date, 'YYYY'), TO_NUMBER(TO_CHAR(sales_date, 'MM')) 
ORDER BY 1, 2;
