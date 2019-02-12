-- 196. 删除重复的电子邮箱
-- 编写一个 SQL 查询，来删除 Person 表中所有重复的电子邮箱，重复的邮箱里只保留 Id 最小 的那个。
--
-- +----+------------------+
-- | Id | Email            |
-- +----+------------------+
-- | 1  | john@example.com |
-- | 2  | bob@example.com  |
-- | 3  | john@example.com |
-- +----+------------------+
-- Id 是这个表的主键。
-- 例如，在运行你的查询语句之后，上面的 Person 表应返回以下几行:
--
-- +----+------------------+
-- | Id | Email            |
-- +----+------------------+
-- | 1  | john@example.com |
-- | 2  | bob@example.com  |
-- +----+------------------+
--
-- https://leetcode-cn.com/problems/delete-duplicate-emails/

-- Solution 1:
DELETE p1 FROM Person p1 INNER JOIN Person p2 ON p1.Email = p2.Email WHERE p1.Id > p2.Id;
-- Solution 2:
DELETE p1 FROM Person p1, Person p2 WHERE p1.Email = p2.Email AND p1.ID > p2.Id;
-- Solution 3:
DELETE FROM Person WHERE Id NOT IN (SELECT Id FROM (SELECT min(Id) AS Id FROM Person GROUP BY Email) tmp);