USE dbsegundo;

SELECT
	ENAME
FROM
	empleados
WHERE
	DEPTNO = 10
	AND JOB IN(
		SELECT
			DISTINCT e.JOB
		FROM
			empleados  e
		JOIN
			departamentos d
		ON
			e.DEPTNO = d.DEPTNO
		WHERE
			d.DNAME = 'SALES'
	);