SELECT category,
    MAX(price) KEEP(DENSE_RANK FIRST ORDER BY price DESC) MAX_PRICE,
    MAX(product_name) KEEP(DENSE_RANK FIRST ORDER BY price DESC) PRODUCT_NAME
FROM food_product
WHERE category IN ('과자', '국', '김치', '식용유')
GROUP BY category
ORDER BY 2 DESC;
