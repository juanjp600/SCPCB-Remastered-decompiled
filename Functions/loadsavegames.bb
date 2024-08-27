Function loadsavegames%()
    Local local0%
    Local local1$
    Local local2%
    Local local3%
    Local local4%
    savegameamount = $00
    If (filetype("Saves\") = $01) Then
        runtimeerror(((("Can't create dir " + chr($22)) + "Saves\") + chr($22)))
    EndIf
    If (filetype("Saves\") = $00) Then
        createdir("Saves\")
    EndIf
    local0 = readdir("Saves\")
    Repeat
        local1 = nextfile(local0)
        If (local1 = "") Then
            Exit
        EndIf
        If (filetype(("Saves\\" + local1)) = $02) Then
            If (((local1 <> ".") And (local1 <> "..")) <> 0) Then
                If (filetype((("Saves\" + local1) + "\save.txt")) > $00) Then
                    savegameamount = (savegameamount + $01)
                EndIf
            EndIf
        EndIf
    Forever
    closedir(local0)
    Dim savegames$((savegameamount + $01))
    local0 = readdir("Saves\")
    local2 = $00
    Repeat
        local1 = nextfile(local0)
        If (local1 = "") Then
            Exit
        EndIf
        If (filetype(("Saves\\" + local1)) = $02) Then
            If (((local1 <> ".") And (local1 <> "..")) <> 0) Then
                If (filetype((("Saves\" + local1) + "\save.txt")) > $00) Then
                    savegames(local2) = local1
                    local2 = (local2 + $01)
                EndIf
            EndIf
        EndIf
    Forever
    closedir(local0)
    Dim savegametime$((savegameamount + $01))
    Dim savegamedate$((savegameamount + $01))
    Dim savegameversion$((savegameamount + $01))
    For local2 = $01 To savegameamount Step $01
        local3 = readfile((("Saves\" + savegames((local2 - $01))) + "\save.txt"))
        savegametime((local2 - $01)) = readstring(local3)
        savegamedate((local2 - $01)) = readstring(local3)
        readint(local3)
        For local4 = $00 To $05 Step $01
            readfloat(local3)
        Next
        readstring(local3)
        readfloat(local3)
        readfloat(local3)
        savegameversion((local2 - $01)) = readstring(local3)
        closefile(local3)
    Next
    Return $00
End Function
