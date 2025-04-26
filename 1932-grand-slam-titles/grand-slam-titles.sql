-- select *
-- from(select player_id,player_name,
-- sum(case when player_id =Wimbledon then 1 else 0 end + 
--     case when player_id = Fr_open then 1 else 0 end + 
--     case when player_id = US_open then 1 else 0 end + 
--     case when player_id = Au_open then 1 else 0 end ) AS grand_slams_count
-- from Players
-- cross join Championships
-- group by player_id,player_name) as r
-- where grand_slams_count > 0

WITH CTE AS 
   (
    SELECT Wimbledon AS id FROM Championships
    UNION ALL 
    SELECT Fr_open AS id FROM Championships
    UNION ALL 
    SELECT US_open AS id FROM Championships
    UNION ALL 
    SELECT Au_open AS id FROM Championships 
   )
   
SELECT player_id,player_name,COUNT(*) AS grand_slams_count
FROM Players JOIN CTE ON Players.player_id = CTE.id
GROUP BY player_id,player_name

