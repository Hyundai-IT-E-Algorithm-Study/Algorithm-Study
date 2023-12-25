SELECT b.author_id, a.author_name, b.category, SUM(bs.sales * b.price) AS total_sales
FROM book b, author a, book_sales bs
WHERE b.author_id = a.author_id AND b.book_id = bs.book_id
AND bs.sales_date BETWEEN '2022-01-01' AND '2022-01-31'
GROUP BY b.author_id, b.category, a.author_name
ORDER BY b.author_id ASC, b.category DESC;

//mysql
