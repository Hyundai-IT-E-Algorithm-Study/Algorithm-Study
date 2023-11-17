SELECT u.user_id, u.nickname
    , u.city||' '||u.street_address1||' '||u.street_address2 AS 전체주소
    , substr(u.TLNO, 1, 3)||'-'||substr(u.TLNO, 4, 4)||'-'||substr(u.TLNO,8) AS 전화번호
FROM used_goods_user u
JOIN (SELECT writer_id, COUNT(*) as c
        FROM used_goods_board
    GROUP BY writer_id
      HAVING COUNT(*) >= 3) b
ON u.user_id = b.writer_id

ORDER BY user_id desc;
