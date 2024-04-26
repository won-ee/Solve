N,M = map(int,input().split())
true_people = list(map(int,input().split()))

if true_people.pop(0):
    set_true_people = set(true_people)
    party_list = []

    for _ in range(M):
        party = list(map(int,input().split()))
        party_list.append(party[1:])

    while 1:
        flag = len(set_true_people)
        set_people = set()
        for true_people in set_true_people:
            for party in party_list:
                for people in party:
                    if people == true_people:
                        for people in party:
                            set_people.add(people)
                        break

        set_true_people.update(set_people)
        if flag == len(set_true_people):
            break

    for i in party_list:
        for j in i:
            if j in set_true_people:
                M -= 1
                break

    print(M)
else:
    print(M)