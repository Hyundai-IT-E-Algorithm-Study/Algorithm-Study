select * 
from(select o.animal_id, o.name
    from animal_ins i, animal_outs o
    where i.animal_id = o.animal_id(+)
    and o.animal_id is not null
    order by (i.datetime - o.datetime)
)
where rownum<=2;
