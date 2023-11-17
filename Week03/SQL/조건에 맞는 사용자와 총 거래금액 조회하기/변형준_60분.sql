SELECT u.user_id, u.nickname, SUM(b.price) AS TOTAL_SALES
FROM used_goods_board b
JOIN used_goods_user u ON b.writer_id = u.user_id
WHERE b.status = 'DONE'
GROUP BY u.user_id, u.nickname
HAVING SUM(b.price) >= 700000
ORDER BY TOTAL_SALES asc;
