Function giveachievement%(arg0%, arg1%)
    Local local0%
    Local local1$
    If (achievements(arg0) <> $01) Then
        achievements(arg0) = $01
        If (usedconsole <> $01) Then
            scpsteam_setachievement(("s" + (Str arg0)))
        EndIf
        If ((achvmsgenabled And arg1) <> 0) Then
            local0 = getinisectionlocation(scpmodding_processfilepath("Data\achievementstrings.ini"), ("s" + (Str arg0)))
            local1 = getinistring2(scpmodding_processfilepath("Data\achievementstrings.ini"), local0, "string1", "")
            createachievementmsg(arg0, local1)
        EndIf
    EndIf
    Return $00
End Function
