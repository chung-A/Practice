package com.chung.six;

public class S5 {
    /**
     * MERCHANTS 테이블은 XX 카드 가맹점 정보를 담은 테이블입니다. MERCHANTS 테이블의 구조는 다음과 같으며, ID, NAME, BUSINESS_ID, TAX_TYPE, CATEGORY_ID는 각각 아이디, 상호명, 사업자등록번호, 과세유형, 업종분류아이디를 나타냅니다. ID는 기본키입니다.
     * NAME	TYPE
     * ID	INT
     * NAME	VARCHAR
     * BUSINESS_ID	VARCHAR
     * TAX_TYPE	VARCHAR
     * CATEGORY_ID	INT
     * CARD_USAGES테이블은 어느 회사원의 카드 사용 내역을 담은 테이블입니다. CARD_USAGES 테이블의 구조는 다음과 같으며, ID, CREATED_AT, CATEGORY, AMOUNT, MERCHANT_ID 는 각각 아이디, 사용일, 구분(0이면 결제 1이면 취소), 금액, 결제 가맹점 아이디를 나타냅니다.
     * NAME	TYPE
     * ID	INT
     * CREATED_AT	DATETIME
     * CATEGORY	INT
     * AMOUNT	INT
     * MERCHANT_ID	INT
     * 문제
     * 이 사람이 가장 돈을 많이 쓴 가맹점은 어딘지, 그리고 그 가맹점에서 쓴 돈은 얼마인지 알아보려 합니다. 가장 돈을 많이 쓴 다섯 가맹점의 아이디, 이름, 사용한 금액을 조회하는 SQL 문을 작성해주세요. 이때 취소 금액은 고려하지 않습니다. 결과는 사용한 금액이 많은 순으로 보여주세요.
     * 예시
     * 예를 들어 MERCHANTS 테이블과 CARD_USAGES 테이블이 다음과 같다면
     * MERCHANTS 테이블
     * ID	NAME	BUSINESS_ID	TAX_TYPE	CATEGORY_ID
     * 3907	KFC학동역	201-81-89723	일반과세자	1
     * 4989	미켈 (Mikelle)고깃집	785-49-00298	일반과세자	1
     * 6297	뉴발란스 강남점	214-85-50334	일반과세자	6
     * 27052	주식회사이마트몰-주식회사이마트몰	104-86-50432	일반과세자	2
     * 118009	플라이앤컴퍼니(주)	211-88-57343	일반과세자	1
     * CARD_USAGES 테이블
     * ID	CREATED_AT	CATEGORY	AMOUNT	MERCHANT_ID
     * 195772	2018-05-02 18:54:43	0	2700	3907
     * 2530342	2019-01-28 09:47:33	0	12300	3907
     * 899325	2018-08-03 16:57:36	0	45000	4989
     * 400811	2018-05-28 12:45:34	0	4000	6297
     * 743640	2018-07-07 11:47:17	0	299000	27052
     * 1052039	2018-08-15 13:40:01	1	-12900	118009
     * 1120840	2018-08-21 06:58:55	0	20800	118009
     * 3907번 가맹점에서 결제한 금액은 2700 + 12300 = 15000입니다.
     * 4989번 가맹점에서 결제한 금액은 45000입니다.
     * 6297번 가맹점에서 결제한 금액은 4000입니다.
     * 27052번 가맹점에서 결제한 금액은 299000입니다.
     * 118009번 가맹점에서 결제한 금액은 20800입니다.
     * 따라서 SQL 문을 실행하면 다음과 같이 나와야 합니다.
     * ID	NAME	결제 금액
     * 27052	주식회사이마트몰-주식회사이마트몰	299000
     * 4989	미켈 (Mikelle)고깃집	45000
     * 118009	플라이앤컴퍼니(주)	20800
     * 3907	KFC학동역	15000
     * 6297	뉴발란스 강남점	4000
     *
     * -- 코드를 입력하세요
     * SELECT m.ID,m.NAME,SUM(c.AMOUNT) as total
     * FROM MERCHANTS m
     *     left join CARD_USAGES c on m.ID=c.MERCHANT_ID
     * where c.CATEGORY='0'
     * group by m.ID
     * order by total desc
     * limit 5;
     */
}
