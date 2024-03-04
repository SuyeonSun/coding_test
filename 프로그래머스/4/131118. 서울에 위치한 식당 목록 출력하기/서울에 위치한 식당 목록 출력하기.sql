-- 식당 ID, 식당 이름, 음식 종류, 즐겨찾기수, 주소, 리뷰 평균 점수
SELECT REST_INFO.REST_ID, REST_INFO.REST_NAME, REST_INFO.FOOD_TYPE, REST_INFO.FAVORITES, REST_INFO.ADDRESS, ROUND(AVG(REVIEW_SCORE), 2) AS SCORE
FROM REST_INFO JOIN REST_REVIEW
ON REST_INFO.REST_ID = REST_REVIEW.REST_ID
GROUP BY REST_INFO.REST_ID
HAVING REST_INFO.ADDRESS LIKE '서울%'
ORDER BY SCORE DESC, REST_INFO.FAVORITES DESC;