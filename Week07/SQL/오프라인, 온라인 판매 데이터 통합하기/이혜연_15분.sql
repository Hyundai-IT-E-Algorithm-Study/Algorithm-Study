SELECT sales_date, product_id, user_id, sales_amount
FROM (SELECT to_char(sales_date, 'YYYY-MM-DD') AS sales_date, product_id, user_id, sales_amount
      FROM online_sale
      WHERE to_char(sales_date, 'YYYY-MM') = '2022-03'
      UNION
      SELECT to_char(sales_date, 'YYYY-MM-DD') AS sales_date, product_id, null, sales_amount
      FROM offline_sale
      WHERE to_char(sales_date, 'YYYY-MM') = '2022-03'
      )
ORDER BY 1, 2, 3
