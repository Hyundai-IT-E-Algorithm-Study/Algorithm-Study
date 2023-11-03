SELECT b.book_id, a.author_name, to_char(b.published_date,'YYYY-MM-DD')
from book b join author a
on a.author_id = b.author_id
where b.category = '경제'
order by b.published_date asc;
