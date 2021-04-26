USE dbsegundo;

SELECT
	*
FROM
	empleados
WHERE
	(
		ENAME REGEXP '^A.*'
		AND SAL > 1000
	) OR (
		COMM IS NOT NULL
		AND COMM != 0
		AND DEPTNO = 30
	);