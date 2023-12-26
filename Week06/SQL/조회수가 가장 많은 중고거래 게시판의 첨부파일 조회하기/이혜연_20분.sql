SELECT '/home/grep/src/'||b.board_id||'/'||f.file_id||f.file_name||f.file_ext as file_path
FROM used_goods_board b INNER JOIN used_goods_file f
ON b.board_id = f.board_id
WHERE (
      SELECT max(views)
      FROM used_goods_board b INNER JOIN used_goods_file f
      ON b.board_id = f.board_id
     ) = views 
order by f.file_id desc
