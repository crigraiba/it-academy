USE dbsegundo;

SELECT
	ENAME
FROM
	empleados
WHERE
	SAL IN(
		SELECT
			MAX(SAL)
		FROM
			empleados
		GROUP BY
			DEPTNO
	);