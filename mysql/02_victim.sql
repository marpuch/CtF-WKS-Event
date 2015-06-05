create view vict_users
as select * from victim_resource.t_vict_users;

create view portfolio
as select * from victim_resource.t_portfolio;

create view private_data
as select * from victim_resource.t_private_data;

create view blog_comments
as select * from victim_resource.t_blog_comments;
