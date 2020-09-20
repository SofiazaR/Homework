№1
select model, speed, hd
from PC
where price < 500

№2
Select distinct maker
from product
where type = 'printer'

№3
Select model, ram, screen
from laptop
where price > 1000

№4
Select * from printer 
where color = 'y'

№5
Select model, speed, hd
from PC
where (cd ='12x' or cd =  '24x') and price < 600

№6
Select distinct maker, speed
from product
join laptop on product.model = laptop.model
where hd >= 10

№7
select pr.model,price
from product as pr
join pc on pc.model = pr.model
where maker ='B'
union
select pr.model,price
from product as pr
join laptop on laptop.model = pr.model
where maker = 'B'
union
select pr.model,price
from product as pr
join printer on printer.model = pr.model
where  maker = 'B'

№8
Select distinct maker
from product
where type = 'pc'
except
select distinct maker
from product
where type = 'laptop'

№9
Select distinct maker
from product
join pc on pc.model = product.model
where speed >=450

№10
Select model,price
from printer
where price = (select max(price) from printer)

№11
Select avg(speed) from pc

№12
Select avg(speed) from laptop
where price > 1000

№13
select avg(speed) from pc
join product on product.model = pc.model
where maker = 'A'

№14
Select distinct ships.class, name, country 
from ships
join classes on ships.class = classes.class
where numGuns >= 10

№15
Select hd
from pc
group by hd
having count(hd) >= 2

№16
Select distinct pc1.model, pc2.model, pc1.speed,pc1.ram 
from pc as pc1, pc as pc2
where pc1.speed = pc2.speed and pc1.ram = pc2.ram  and pc1.model > pc2.model

№17
select distinct type, lp.model, lp.speed
from laptop as lp, product
where lp.speed < (select min(speed) from pc) and type='laptop'

№18
select distinct maker, price
from product, printer
where product.model = printer.model and color = 'y' and price = (select min(price) from printer where color = 'y')

№19
Select maker, avg(screen)
from product,laptop
where product.model = laptop.model
group by maker

№20
Select maker, count(model)
from product
where type = 'pc'
group by maker having count(model)>=3

№21
Select maker, max(price)
from product,pc
where product.model = pc.model
group by maker

№22
Select speed, avg(price)
from pc
where speed > 600
group by speed

№23
Select maker
from product
join pc on  product.model = pc.model 
where speed>=750
intersect
select maker
from product as pr
join laptop on pr.model = laptop.model
where speed >= 750

№24
select model
from (select model, price from pc
union
select model, price from laptop
union
select model, price from printer) as a
where price = (select max(price) from(
select model, price from pc
union
select model, price from laptop
union
select model, price from printer)
as aa)

№25
select maker
from product
where type = 'printer'
intersect
select maker from product
join pc on pc.model = product.model
where pc.ram = (select min(ram) from pc)
and pc.speed = (select max(speed) from (select speed from pc where ram = (select min(ram) from pc))as aa)

№26
select avg(price)
from
(select price from pc
join product on product.model = pc.model
where maker = 'A'
union all
select price from laptop
join product on product.model = laptop.model
where maker = 'A') as aa

№27
select maker,avg(hd)
from product
join pc on product.model = pc.model
where maker in (select maker from product where type='printer')
group by maker

№28
select count(*) from(Select maker
from product
group by maker having count(model) = 1) as k

№29
select ine.point,ine.date,inc,out
from income_o as ine
left join outcome_o as oue on oue.point=ine.point and oue.date = ine.date
union
select oue.point,oue.date,inc,out
from outcome_o as oue
left join income_o as ine on oue.point=ine.point and oue.date = ine.date

№30
select point, date, sum(out), sum(inc) from (Select point,date,null as out, sum(inc) as inc
from income
group by point, date
union
select point, date, sum(out) as out, null as inc
from outcome
group by point, date) as aa
group by point, date
