SELECT cart_id
FROM cart_products
WHERE name = 'Yogurt'
INTERSECT
SELECT cart_id
FROM cart_products
WHERE name = 'Milk'
