SELECT b.category, sum(s.sales) as total_sales
from book b join book_sales s
on b.book_id = s.book_id
where to_char(s.sales_date, 'YYYY-MM') = '2022-01'
group by b.category
order by b.category asc;
