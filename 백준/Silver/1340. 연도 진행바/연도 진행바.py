string = input().split(' ')                                # 전체 문자열 공백으로 나눠 입력 받기

month = string[0]                                          # 문자열 string의 첫 번째 요소는 현재 월
# dd = int(string[1][0:len(string[1])-1])
dd = int(string[1][:-1])                                  # string의 두 번째 요소에서 맨 뒤의 콤마를 제외한 것이 현재 일

yyyy = int(string[2])                                      # string의 세 번째 요소는 현재 연도

hh, mm = map(int, string[3].split(':'))                    # string의 네 번째 요소에서 콜론을 기준으로 분리한 것이 각각 현재 시와 분


month_name = ["January", "February", "March", "April", "May", "June",                   # 모든 달의 이름
              "July", "August", "September", "October", "November", "December"]         


month_day = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]                            # 각 달의 마지막 일 수 (평년 기준)


if yyyy % 400 == 0 or (yyyy % 4 == 0 and yyyy % 100 != 0):                   # 만약 입력한 연도가 윤년일 때
    month_day[1] += 1                                                        # 2월의 마지막 일 수에 +1 

all_time = sum(month_day)*24*60                                              # 그 해의 전체 시간을 분으로 바꾸기

month_idx = month_name.index(month)                                          # month_name에서 month에 해당되는 요소의 인덱스 저장

current_time = (sum(month_day[:month_idx])+dd-1)*24*60+hh*60+mm              # 현재까지의 시간을 모두 분으로 바꾸기

print(current_time/all_time*100) 