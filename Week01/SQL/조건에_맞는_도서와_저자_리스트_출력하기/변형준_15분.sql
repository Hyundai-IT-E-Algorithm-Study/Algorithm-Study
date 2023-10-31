SELECT b.book_id, a.author_name, TO_CHAR(b.published_date, 'YYYY-MM-DD') AS PUBLISHED_DATE
FROM book b
JOIN author a
ON b.author_id = a.author_id
AND b.category = '경제'
ORDER BY b.published_date asc;
