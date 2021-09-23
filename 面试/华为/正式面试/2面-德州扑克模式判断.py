from collections import defaultdict
def findPattern(cardGroup):
    cardGroup = cardGroup.split()
    if len(cardGroup) != 5:
        return "UnKnown"
    cardNum = ['1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D']
    cardColor = set(["H", 'S', 'C', 'D'])
    dicNum = defaultdict(int)
    dicCol = defaultdict(int)
    for card in cardGroup:
        if card[0] not in cardNum or card[1] not in cardColor:
            print(card)
            return "UnKnown"
        dicNum[card[0]] += 1
        dicCol[card[1]] += 1

    if len(dicCol.keys()) == 1:
        for i in range(8, -1, -1):
            if len(set(cardNum[i:i+5]) & set(dicNum.keys())) == 5:
                if i == 8:
                    return "LargestFlush"
                else:
                    return "StrainghtFlush"
        return "Flush"
    elif len(dicCol.keys()) == 4:
        if len(dicNum.keys()) != 2:
            return "UnKnown"
        for i in dicNum.keys():
            if dicNum[i] in (1, 4):
                return "FourofaKind"
            else:
                return "UnKnown"
    # 应该是理解错题中描述的模式了，
    # elif len(dicCol.keys()) == 2:
    #     if len(dicNum.keys()) != 2:
    #         return "UnKnown"
    #     for i in dicNum.keys():
    #         if dicNum[i] in (2, 3):
    #             return "FullHouse"
    #         else:
    #             return "UnKnown"
    # elif len(dicCol.keys()) == 3:
    #     return "UnKnown"
    
    # 更正
    else:
        if len(dicNum.keys()) == 2:
            for i in dicNum.keys():
                if dicNum[i] in (2, 3):
                    return "FullHouse"
                else:
                    return "UnKnown"
        else:
            return "UnKnown"
print(findPattern("9H AH BH CH DH"))
print(findPattern("9H AH 2H 3H DH"))
print(findPattern("9H AH 2H 3S DS"))


        