USE dbsegundo;

-- Consulta 1:

SELECT
	*
FROM
	empleados;
	
-- Consulta 2:

SELECT
	*
FROM
	departamentos;

-- Consulta 3:

SELECT
	*
FROM
	empleados
WHERE
	JOB = 'CLERK';

-- Consulta 4:

SELECT
	*
FROM
	empleados
WHERE
	JOB = 'CLERK'
ORDER BY
	ENAME;

-- Consulta 5:

SELECT
	EMPNO,
	DEPTNO,
	ENAME,
	JOB,
	MGR,
	HIREDATE,
	SAL,
	COMM
FROM
	empleados
HAVING
	JOB IN('CLERK')
ORDER BY
	ENAME;

-- Consulta 6:

SELECT
	EMPNO,
	ENAME,
	SAL
FROM
	empleados;

-- Consulta 7:

SELECT
	DNAME
FROM
	departamentos;

-- Consulta 8:

SELECT
	DNAME
FROM
	departamentos
ORDER BY
	DNAME;

-- Consulta 9:

SELECT
	DNAME
FROM
	departamentos
ORDER BY
	LOC;

-- Consulta 10:

SELECT
	DNAME
FROM
	departamentos
ORDER BY
	LOC DESC;

-- Consulta 11:

SELECT
	ENAME,
	JOB
FROM
	empleados
ORDER BY
	SAL;

-- Consulta 12:

SELECT
	ENAME,
	JOB
FROM
	empleados
ORDER BY
	JOB,
	SAL;

-- Consulta 13:

SELECT
	ENAME,
	JOB
FROM
	empleados
ORDER BY
	JOB DESC,
	SAL;

-- Consulta 14:

SELECT
	SAL,
	COMM
FROM
	empleados
WHERE
	DEPTNO = 30;

-- Consulta 15:

SELECT
	SAL,
	COMM
FROM
	empleados
WHERE
	DEPTNO = 30
ORDER BY
	COMM;

-- Consulta 16a:

SELECT
	COMM
FROM
	empleados;

-- Consulta 16b:

SELECT
	DISTINCT COMM
FROM
	empleados;

-- Consulta 17:

SELECT 
	DISTINCTROW 
		ENAME,
		COMM
FROM
	empleados;

-- Consulta 18:

SELECT 
	DISTINCTROW
		ENAME,
		SAL
FROM
	empleados;

-- Consulta 19:

SELECT
	DISTINCTROW
		COMM,
		DEPTNO
FROM
	empleados;

-- Consulta 20:

SELECT
	ENAME,
	SAL+1000
FROM
	empleados
WHERE
	DEPTNO = 30;

-- Consulta 21:

SELECT
	ENAME,
	SAL,
	SAL+1000 AS NUEVO_SALARIO
FROM
	empleados
WHERE
	DEPTNO = 30;

-- Consulta 22:

SELECT
	ENAME
FROM
	empleados
WHERE
	COMM > SAL/2;

-- Consulta 23:

SELECT
	ENAME
FROM
	empleados
WHERE
	COMM IS NULL
	OR COMM <= 0.25*SAL;

-- Consulta 24:

SELECT
	CONCAT('Nombre: ', ENAME) AS NOMBRE,
	CONCAT('Salario: ', SAL) AS SALARIO
FROM
	empleados;

-- Consulta 25:

SELECT
	EMPNO,
	SAL,
	COMM
FROM
	empleados
WHERE
	EMPNO > 7500;

-- Consulta 26:

SELECT
	*
FROM
	empleados
WHERE
	ASCII(ENAME) >= ASCII('J');

-- Consulta 27:

SELECT
	SAL,
	COMM,
	SAL+COMM AS SALARIO_TOTAL
FROM
	empleados
WHERE
	COMM IS NOT NULL
ORDER BY
	EMPNO;

-- Consulta 28:

SELECT
	SAL,
	COMM,
	SAL AS SALARIO_TOTAL
FROM
	empleados
WHERE
	COMM IS NULL
ORDER BY
	EMPNO;

-- Consulta 29:

SELECT
	ENAME
FROM
	empleados
WHERE
	SAL > 1000
	AND MGR = 7698;

-- Consulta 30:

SELECT
	ENAME
FROM
	empleados
WHERE NOT (
	SAL > 1000
	AND MGR = 7698
);

-- Consulta 31:

SELECT
	(COMM/SAL)*100 AS PORCENTAJE
FROM
	empleados
ORDER BY
	ENAME;

-- Consulta 32:

SELECT
	ENAME
FROM
	empleados
WHERE
	DEPTNO = 10
	AND ENAME NOT LIKE '%LA%';

-- Consulta 33:

SELECT
	ENAME
FROM
	empleados
WHERE
	MGR IS NULL;

-- Consulta 34:

SELECT
	DNAME
FROM
	departamentos
WHERE
	DNAME NOT IN('SALES', 'RESEARCH')
ORDER BY
	LOC;

-- Consulta 35:

SELECT
	ENAME,
	DEPTNO
FROM
	empleados
WHERE
	JOB = 'CLERK'
	AND DEPTNO != 10
	AND SAL > 800
ORDER BY
	HIREDATE;

-- Consulta 36:

SELECT
	ENAME,
	SAL/COMM AS COCIENTE
FROM
	empleados
WHERE
	COMM IS NOT NULL
	AND COMM != 0
ORDER BY
	ENAME;

-- Consulta 37:

SELECT
	*
FROM
	empleados
WHERE
	LENGTH(ENAME) = 5;

-- Consulta 38:

SELECT
	*
FROM
	empleados
WHERE
	LENGTH(ENAME) >= 5;

-- Consulta 39:

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

-- Consulta 40:

SELECT
	ENAME,
	SAL,
	IFNULL(SAL+COMM, SAL) AS SALARIO_TOTAL
FROM
	empleados
ORDER BY
	SAL,
	SALARIO_TOTAL;

-- Consulta 41:

SELECT
	ENAME,
	SAL,
	COMM
FROM
	empleados
WHERE
	SAL BETWEEN COMM/2 AND COMM;

-- Consulta 42:

SELECT
	ENAME,
	SAL,
	COMM
FROM
	empleados
WHERE
	SAL NOT BETWEEN COMM/2 AND COMM;

-- Consulta 43:

SELECT
	ENAME,
	JOB
FROM
	empleados
WHERE
	JOB REGEXP '.*MAN$'
	AND ENAME REGEXP '^A.*';

-- Consulta 44:

SELECT
	ENAME,
	JOB
FROM
	empleados
WHERE
	CONCAT(ENAME, JOB) REGEXP '^A.*MAN$';

-- Consulta 45:

SELECT
	ENAME
FROM
	empleados
WHERE
	LENGTH(ENAME) <= 5;

-- Consulta 46:

SELECT
	ENAME,
	(
		CASE
			WHEN COMM > 0 THEN 'YES'
			WHEN COMM = 0 THEN 'NO'
			WHEN COMM IS NULL THEN 'UNKNOWN'
		END
	) AS COMM,
	IFNULL(SAL+COMM, SAL) AS SALARIO_TOTAL,
	IFNULL(SAL+COMM, SAL)*1.06 AS '6%',
	IFNULL(SAL+COMM, SAL)*1.07 AS '7%'
FROM
	empleados
ORDER BY
	ENAME;

-- Consulta 47:

SELECT
	ENAME,
	HIREDATE
FROM
	empleados
WHERE
	JOB != 'SALESMAN';

-- Consulta 48:

SELECT
	*
FROM
	empleados
WHERE
	EMPNO IN(7844, 7900, 7521, 7782, 7934, 7678, 7369)
	AND EMPNO NOT IN(7902, 7839, 7499, 7878);

-- Consulta 49:

SELECT
	*
FROM
	empleados
ORDER BY
	DEPTNO,
	EMPNO DESC;

-- Consulta 50:

SELECT
	ENAME
FROM
	empleados
WHERE
	MGR > EMPNO
	AND (
		SAL BETWEEN 1000 AND 2000
		OR DEPTNO = 30
	);

-- Consulta 51:

SELECT
	MAX(SAL),
	SUM(COMM),
	COUNT(*)
FROM
	empleados;

-- Consulta 52:

SELECT
	*
FROM
	empleados
WHERE
	SAL > (
		SELECT
			SAL
		FROM
			empleados
		WHERE
			EMPNO = 7934
		)
ORDER BY
	SAL;

-- Consulta 53:

SELECT
	ENAME,
	JOB,
	SAL
FROM
	empleados
WHERE
	SAL > (
		SELECT
			SAL
		FROM
			empleados
		WHERE
			ENAME = 'Allen'
		)
	OR ENAME = 'Allen';

-- Consulta 54:

SELECT
	MAX(ENAME)
FROM
	empleados;

-- Consulta 55:

SELECT
	MAX(SAL) AS SAL_MAS_ALTO,
	MIN(SAL) AS SAL_MAS_BAJO,
	MAX(SAL)-MIN(SAL) AS DIFERENCIA
FROM
	empleados;

-- Consulta 56:

SELECT
	ENAME,
	SAL
FROM
	empleados
WHERE
	SAL IN (
		(
			SELECT
				MIN(SAL)
			FROM
				empleados
		), (
			SELECT
				MAX(SAL)
			FROM
				empleados
		)
	);

-- Consulta 57:

SELECT
	e.DEPTNO,
	d.DNAME,
	AVG(e.SAL)
FROM
	empleados e
JOIN
	departamentos d
ON
	e.DEPTNO = d.DEPTNO
WHERE
	e.SAL < 5000
GROUP BY
	e.DEPTNO
HAVING
	MIN(e.SAL) > 900;

-- Consulta 58:

SELECT
	e.ENAME
FROM
	empleados e
JOIN
	departamentos d
ON
	e.DEPTNO = d.DEPTNO
WHERE
	LENGTH(d.LOC) > 5
ORDER BY
	d.LOC DESC,
	e.ENAME;

-- Consulta 59:

SELECT
	ENAME
FROM
	empleados
WHERE
	SAL >= (
		SELECT
			AVG(SAL)
		FROM
			empleados
	);

-- Consulta 60:

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

-- Consulta 61:

SELECT
	COUNT(DISTINCT JOB) AS NUM_JOB,
	COUNT(*) AS NUM_EMP,
	COUNT(DISTINCT SAL) AS NUM_SAL,
	SUM(SAL)
FROM
	empleados
WHERE
	DEPTNO = 30;

-- Consulta 62:

SELECT
	COUNT(*)
FROM
	empleados
WHERE
	COMM IS NOT NULL
	AND COMM != 0;

-- Consulta 63:

SELECT
	COUNT(*) AS NUM_EMP
FROM
	empleados
WHERE
	DEPTNO = 20;

-- Consulta 64:

SELECT
	DEPTNO,
	COUNT(*) AS NUM_EMP
FROM
	empleados
GROUP BY
	DEPTNO
HAVING
	COUNT(*) > 3;

-- Consulta 65:

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

-- Consulta 66:

SELECT
	e1.ENAME
FROM
	empleados e1
JOIN
	empleados e2
ON
	e1.EMPNO = e2.MGR
GROUP BY
	e1.EMPNO
ORDER BY
	e1.ENAME DESC;

-- Consulta 67:

SELECT
	*
FROM
	empleados
HAVING
	JOB IN(
		SELECT
			DISTINCT e.JOB
		FROM
			empleados e
		JOIN
			departamentos d
		ON
			e.DEPTNO = d.DEPTNO
		WHERE
			d.LOC = 'CHICAGO'
	)
ORDER BY
	JOB;

-- Consulta 68:

SELECT
	JOB,
	COUNT(*)
FROM
	empleados
GROUP BY
	JOB
ORDER BY
	JOB;

-- Consulta 69:

SELECT
	d.DNAME,
	SUM(e.SAL) AS 'SUM(SAL)'
FROM
	empleados e
JOIN
	departamentos d
ON
	e.DEPTNO = d.DEPTNO
GROUP BY
	e.DEPTNO
ORDER BY
	d.DNAME;

-- Consulta 70:

SELECT
	DNAME
FROM
	departamentos
GROUP BY
	DEPTNO
HAVING
	DEPTNO NOT IN(
		SELECT
			DISTINCT DEPTNO
		FROM
			empleados
	);

-- Consulta 71:

SELECT
	ENAME
FROM
	empleados
WHERE
	EMPNO NOT IN(
		SELECT
			DISTINCT MGR
		FROM
			empleados
		WHERE
			MGR IS NOT NULL
	);

-- Consulta 72:

SELECT
	d.DNAME,
	AVG(e.SAL*12) AS 'AVG(SAL_MENSUAL)',
	COUNT(*) AS NUM_EMP
FROM
	empleados e
JOIN
	departamentos d
ON
	e.DEPTNO = d.DEPTNO
GROUP BY
	e.DEPTNO
ORDER BY
	d.DNAME;

-- Consulta 73:

SELECT
	ENAME
FROM
	empleados
WHERE
	DEPTNO = 30
ORDER BY
	COMM DESC;

-- Consulta 74:

SELECT
	e.ENAME
FROM
	empleados e
JOIN
	departamentos d
ON
	e.DEPTNO = d.DEPTNO
WHERE
	d.LOC IN ('DALLAS', 'NEW YORK');

-- Consulta 75:

SELECT
	e1.ENAME AS EMPLEADO,
	e2.ENAME AS JEFE
FROM
	empleados e1
LEFT JOIN
	empleados e2
ON
	e1.MGR = e2.EMPNO
ORDER BY
	e2.ENAME;

-- Consulta 76:

SELECT
	e.ENAME,
	e.SAL,
	d.DNAME
FROM
	empleados e
JOIN
	departamentos d
ON
	e.DEPTNO = d.DEPTNO
WHERE
	SAL IN (
		SELECT
			MAX(SAL)
		FROM
			empleados
		GROUP BY
			DEPTNO
	);

-- Consulta 77:

SELECT
	e1.ENAME,
	e1.EMPNO,
	COUNT(e2.EMPNO) AS NUM_EMP
FROM
	empleados e1
RIGHT JOIN
	empleados e2
ON
	e1.EMPNO = e2.MGR
GROUP BY
	e1.EMPNO;

-- Consulta 78:

SELECT
	d.DNAME,
	SUM(e.SAL)
FROM
	empleados e
JOIN
	departamentos d
ON
	e.DEPTNO = d.DEPTNO
GROUP BY
	e.DEPTNO
ORDER BY
	SUM(e.SAL) DESC
LIMIT
	1;

-- Consulta 79:

SELECT
	e1.*
FROM
	empleados e1
JOIN
	(
		SELECT
			DISTINCT SAL
		FROM
			empleados
		GROUP BY
			SAL
		ORDER BY
			SAL DESC			
		LIMIT
			2
	) e2
ON
	e1.SAL = e2.SAL
ORDER BY
	e1.SAL DESC;

-- Consulta 80:

SELECT
	d.LOC,
	COUNT(e.EMPNO) AS NUM_EMP
FROM
	empleados e
JOIN
	departamentos d
ON
	e.DEPTNO = d.DEPTNO
WHERE
	d.LOC NOT IN(
		SELECT
			d.LOC
		FROM
			empleados e
		RIGHT JOIN
			departamentos d
		ON
			e.DEPTNO = d.DEPTNO
		GROUP BY
			e.DEPTNO
		HAVING
			COUNT(e.EMPNO) = 0
	)
GROUP BY
	e.DEPTNO
HAVING
	NUM_EMP >= 4;