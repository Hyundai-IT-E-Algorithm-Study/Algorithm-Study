SELECT a.author_id, a.author_name, b.category, sum(s.sales*b.price)as total_sales
FROM book b, author a, book_sales s
WHERE b.book_id = s.book_id 
      AND b.author_id = a.author_id
      AND to_char(s.sales_date,'YYYYMM')='202201' 
group by a.author_id, a.author_name, b.category
order by 1 asc, 3 desc
