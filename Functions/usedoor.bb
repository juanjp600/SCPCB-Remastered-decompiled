Function usedoor%(arg0.doors, arg1%, arg2%)
    Local local0.fps_settings
    Local local1%
    Local local4%
    local0 = (First fps_settings)
    local1 = $00
    If (arg0\Field12 > $00) Then
        If (selecteditem = Null) Then
            If (arg1 = $01) Then
                If ((((instr(msg, scplang_getphrase("ingame.thekey"), $01) = $00) And (instr(msg, scplang_getphrase("ingame.withkey"), $01) = $00)) Or (210.0 > msgtimer)) <> 0) Then
                    msg = scplang_getphrase("ingame.keyrequired")
                    msgtimer = 490.0
                EndIf
            EndIf
            Return $00
        Else
            Select selecteditem\Field3\Field1
                Case "key6"
                    local1 = $01
                Case "key0"
                    local1 = $02
                Case "key1"
                    local1 = $03
                Case "key2"
                    local1 = $04
                Case "key3"
                    local1 = $05
                Case "key4"
                    local1 = $06
                Case "key5"
                    local1 = $07
                Case "key7"
                    local1 = $08
                Case "scp005"
                    local1 = $09
                Default
                    local1 = $FFFFFFFF
            End Select
            If (local1 = $FFFFFFFF) Then
                If (arg1 = $01) Then
                    If ((((instr(msg, scplang_getphrase("ingame.thekey"), $01) = $00) And (instr(msg, scplang_getphrase("ingame.withkey"), $01) = $00)) Or (210.0 > msgtimer)) <> 0) Then
                        msg = scplang_getphrase("ingame.keyrequired")
                        msgtimer = 490.0
                    EndIf
                EndIf
                Return $00
            ElseIf (local1 >= arg0\Field12) Then
                selecteditem = Null
                If (arg1 = $01) Then
                    If (arg0\Field4 <> 0) Then
                        playsound_strict(keycardsfx2)
                        If (local1 = $09) Then
                            msg = scplang_getphrase("ingame.nothingh")
                        ElseIf (local1 = $01) Then
                            msg = ((((scplang_getphrase("ingame.nothingh2") + " ") + chr($22)) + scplang_getphrase("ingame.l6err")) + chr($22))
                        Else
                            msg = scplang_getphrase("ingame.nothingh3")
                        EndIf
                        msgtimer = 490.0
                        Return $00
                    ElseIf (local1 = $09) Then
                        playsound_strict(keycardsfx1)
                        msg = scplang_getphrase("ingame.keys")
                        msgtimer = 350.0
                    Else
                        playsound_strict(keycardsfx1)
                        msg = scplang_getphrase("ingame.cards")
                        msgtimer = 490.0
                    EndIf
                EndIf
            Else
                selecteditem = Null
                If (arg1 = $01) Then
                    playsound_strict(keycardsfx2)
                    If (arg0\Field4 <> 0) Then
                        If (local1 = $09) Then
                            msg = scplang_getphrase("ingame.nothingh")
                        ElseIf (local1 = $01) Then
                            msg = ((((scplang_getphrase("ingame.nothingh2") + " ") + chr($22)) + scplang_getphrase("ingame.l6err")) + chr($22))
                        Else
                            msg = scplang_getphrase("ingame.nothingh3")
                        EndIf
                    ElseIf (local1 = $01) Then
                        msg = ((((scplang_getphrase("ingame.nothingh2") + " ") + chr($22)) + scplang_getphrase("ingame.l6err")) + chr($22))
                    Else
                        msg = ((((scplang_getphrase("ingame.carderr1") + " ") + (Str (arg0\Field12 - $02))) + " ") + scplang_getphrase("ingame.carderr2"))
                    EndIf
                    msgtimer = 490.0
                EndIf
                Return $00
            EndIf
        EndIf
    ElseIf (arg0\Field12 < $00) Then
        If (selecteditem <> Null) Then
            local1 = ((((selecteditem\Field3\Field1 = "hand") And (arg0\Field12 = $FFFFFFFF)) Or ((selecteditem\Field3\Field1 = "hand2") And (arg0\Field12 = $FFFFFFFE))) Or ((selecteditem\Field3\Field1 = "hand3") And (arg0\Field12 = $FFFFFFFD)))
        EndIf
        If (local1 <> $00) Then
            playsound_strict(scannersfx1)
            If (((instr(msg, scplang_getphrase("ingame.placedyour"), $01) = $00) Or (210.0 > msgtimer)) <> 0) Then
                msg = scplang_getphrase("ingame.scannergoodhand")
            EndIf
            msgtimer = 490.0
        Else
            local1 = $00
            If (selecteditem <> Null) Then
                If (selecteditem\Field3\Field1 = "scp005") Then
                    local1 = $01
                EndIf
                If (((((((((selecteditem\Field3\Field1 = "key0") Or (selecteditem\Field3\Field1 = "key1")) Or (selecteditem\Field3\Field1 = "key2")) Or (selecteditem\Field3\Field1 = "key3")) Or (selecteditem\Field3\Field1 = "key4")) Or (selecteditem\Field3\Field1 = "key5")) Or (selecteditem\Field3\Field1 = "key6")) Or (selecteditem\Field3\Field1 = "key7")) <> 0) Then
                    local1 = $02
                EndIf
            EndIf
            If (local1 = $00) Then
                If (arg1 = $01) Then
                    playsound_strict(scannersfx2)
                    msg = scplang_getphrase("ingame.scannerbad")
                    msgtimer = 490.0
                    Return $00
                EndIf
            ElseIf (local1 = $01) Then
                playsound_strict(scannersfx1)
                msg = scplang_getphrase("ingame.scannerwtf")
                msgtimer = 490.0
            ElseIf (local1 = $02) Then
                msg = scplang_getphrase("ingame.scannererr")
                msgtimer = 490.0
                Return $00
            EndIf
        EndIf
    ElseIf (arg0\Field4 <> 0) Then
        If (arg1 = $01) Then
            If ((arg0\Field23 > $00) = $00) Then
                playsound_strict(buttonsfx2)
                If (playerroom\Field7\Field10 <> "room2elevator") Then
                    If (arg0\Field5 <> 0) Then
                        msg = scplang_getphrase("ingame.doorend1")
                    Else
                        msg = scplang_getphrase("ingame.doorend2")
                    EndIf
                Else
                    msg = scplang_getphrase("ingame.elevator1")
                EndIf
                msgtimer = 350.0
            ElseIf (arg0\Field23 = $01) Then
                msg = scplang_getphrase("ingame.elevator2")
                msgtimer = 350.0
            ElseIf (arg0\Field23 = $03) Then
                msg = scplang_getphrase("ingame.elevator3")
                msgtimer = 350.0
            ElseIf (msg <> scplang_getphrase("ingame.elevator2")) Then
                If (((msg = scplang_getphrase("ingame.elevator4")) Or (210.0 > msgtimer)) <> 0) Then
                    Select rand($0A, $01)
                        Case $01
                            msg = scplang_getphrase("ingame.elevator5")
                            msgtimer = 490.0
                        Case $02
                            msg = scplang_getphrase("ingame.elevator6")
                            msgtimer = 490.0
                        Case $03
                            msg = scplang_getphrase("ingame.elevator7")
                            msgtimer = 490.0
                        Case $04
                            msg = scplang_getphrase("ingame.elevator8")
                            msgtimer = 490.0
                        Case $05
                            msg = scplang_getphrase("ingame.elevator9")
                            msgtimer = 490.0
                        Default
                            msg = scplang_getphrase("ingame.elevator4")
                            msgtimer = 490.0
                    End Select
                EndIf
            Else
                msg = scplang_getphrase("ingame.elevator4")
                msgtimer = 490.0
            EndIf
        EndIf
        Return $00
    EndIf
    arg0\Field5 = (arg0\Field5 = $00)
    If (arg0\Field22 <> Null) Then
        arg0\Field22\Field5 = (arg0\Field22\Field5 = $00)
    EndIf
    local4 = $00
    If (arg0\Field9 = $01) Then
        local4 = rand($00, $01)
    Else
        local4 = rand($00, $02)
    EndIf
    If (arg2 = $01) Then
        If (arg0\Field5 <> 0) Then
            If (arg0\Field22 <> Null) Then
                arg0\Field22\Field11 = (Float arg0\Field22\Field10)
            EndIf
            arg0\Field11 = (Float arg0\Field10)
            arg0\Field16 = playsound2(opendoorsfx(arg0\Field9, local4), camera, arg0\Field0, 10.0, 1.0)
        Else
            arg0\Field16 = playsound2(closedoorsfx(arg0\Field9, local4), camera, arg0\Field0, 10.0, 1.0)
        EndIf
        updatesoundorigin(arg0\Field16, camera, arg0\Field0, 10.0, 1.0)
    ElseIf (arg0\Field5 <> 0) Then
        If (arg0\Field22 <> Null) Then
            arg0\Field22\Field11 = (Float arg0\Field22\Field10)
        EndIf
        arg0\Field11 = (Float arg0\Field10)
    EndIf
    Return $00
End Function
