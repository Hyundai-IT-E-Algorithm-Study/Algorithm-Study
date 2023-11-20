SELECT u.user_id, u.nickname, (u.CITY || ' ' || u.STREET_ADDRESS1 || ' ' || u.STREET_ADDRESS2) as 전체주소, ('010-' || substr(u.tlno, 4, 4) || '-' || substr(u.tlno, 8, 4)) as 전화번호
from used_goods_board b join used_goods_user u
on b.writer_id = u.user_id
group by 
    u.user_id, 
    u.nickname, 
    u.CITY, 
    u.STREET_ADDRESS1, 
    u.STREET_ADDRESS2, 
    u.tlno
having count(u.user_id) >= 3
order by u.user_id desc;
