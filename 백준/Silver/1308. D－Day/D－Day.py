import datetime

year1, month1, day1 = map(int, input().split())
year2, month2, day2 = map(int, input().split())

start_date = datetime.date(year1, month1, day1)
target_date = datetime.date(year2, month2, day2)

d_day = target_date - start_date

if d_day.days >= 365243:
    print("gg")
else:
    print("D-"+str(d_day.days))