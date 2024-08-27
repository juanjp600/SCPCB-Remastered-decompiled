Function pickitem%(arg0.items)
    Local local0%
    Local local1%
    Local local2%
    Local local4.events
    Local local5%
    local0 = $00
    local1 = $01
    local2 = $01
    For local0 = $00 To (maxitemamount - $01) Step $01
        If (inventory(local0) = Null) Then
            local2 = $00
            Exit
        EndIf
    Next
    If (wearinghazmat > $00) Then
        msg = scplang_getphrase("items.hazmaterr")
        msgtimer = 350.0
        Return $00
    EndIf
    If (local2 = $00) Then
        For local0 = $00 To (maxitemamount - $01) Step $01
            If (inventory(local0) = Null) Then
                Select arg0\Field3\Field1
                    Case "scp1123"
                        If (((((i_714\Field0 = $01) = $00) And ((wearinggasmask = $03) = $00)) And ((wearinghazmat = $03) = $00)) <> 0) Then
                            If (playerroom\Field7\Field10 <> "room1123") Then
                                showentity(at\Field4[$0E])
                                lightflash = 7.0
                                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\1123\Touch.ogg")))
                                If (i_1033ru\Field0 = $00) Then
                                    deathmsg = scplang_getphrase("items.itemscp1123d")
                                    kill($00, $00)
                                Else
                                    damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $46))
                                EndIf
                            EndIf
                            For local4 = Each events
                                If (local4\Field0 = "room1123") Then
                                    If (0.0 = local4\Field2) Then
                                        showentity(at\Field4[$0E])
                                        lightflash = 3.0
                                        playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\1123\Touch.ogg")))
                                    EndIf
                                    local4\Field2 = max(1.0, local4\Field2)
                                    Exit
                                EndIf
                            Next
                        EndIf
                        Return $00
                    Case "killbat"
                        showentity(at\Field4[$0E])
                        lightflash = 1.0
                        playsound_strict(introsfx($0B))
                        If (i_1033ru\Field0 = $00) Then
                            deathmsg = scplang_getphrase("items.killbat")
                            kill($00, $00)
                        Else
                            damage1033ru((i_1033ru\Field2 * $64))
                        EndIf
                    Case "scp148"
                        giveachievement($08, $01)
                    Case "scp513"
                        giveachievement($0F, $01)
                    Case "scp860"
                        giveachievement($12, $01)
                    Case "key7"
                        giveachievement($21, $01)
                    Case "veryfinevest"
                        msg = scplang_getphrase("items.finevest")
                        msgtimer = 420.0
                        Exit
                    Case "firstaid","finefirstaid","firstaid2"
                        arg0\Field13 = 0.0
                    Case "navigator","nav"
                        If (arg0\Field3\Field0 = "S-NAV Navigator Ultimate") Then
                            giveachievement($23, $01)
                        EndIf
                    Case "hazmatsuit","hazmatsuit2","hazmatsuit3"
                        If (i_1499\Field0 > $00) Then
                            msg = scplang_getphrase("items.hazmaterr1")
                            msgtimer = 350.0
                            selecteditem = Null
                            Return $00
                        ElseIf (i_178\Field0 > $00) Then
                            msg = scplang_getphrase("items.hazmaterr2")
                            msgtimer = 350.0
                            selecteditem = Null
                            Return $00
                        ElseIf (i_215\Field0 > $00) Then
                            msg = scplang_getphrase("items.hazmaterr3")
                            msgtimer = 350.0
                            selecteditem = Null
                            Return $00
                        ElseIf (wearingnightvision > $00) Then
                            msg = scplang_getphrase("items.hazmaterr4")
                            msgtimer = 350.0
                            selecteditem = Null
                            Return $00
                        ElseIf (wearinggasmask > $00) Then
                            msg = scplang_getphrase("items.hazmaterr5")
                            msgtimer = 350.0
                            selecteditem = Null
                            Return $00
                        Else
                            local1 = $01
                            For local5 = $00 To (maxitemamount - $01) Step $01
                                If (inventory(local5) <> Null) Then
                                    If ((((inventory(local5)\Field3\Field1 = "hazmatsuit") Or (inventory(local5)\Field3\Field1 = "hazmatsuit2")) Or (inventory(local5)\Field3\Field1 = "hazmatsuit3")) <> 0) Then
                                        local1 = $00
                                        Exit
                                    ElseIf (((inventory(local5)\Field3\Field1 = "vest") Or (inventory(local5)\Field3\Field1 = "finevest")) <> 0) Then
                                        local1 = $02
                                        Exit
                                    EndIf
                                EndIf
                            Next
                            If (local1 = $00) Then
                                msg = scplang_getphrase("items.hazmaterr6")
                                msgtimer = 350.0
                                Return $00
                            ElseIf (local1 = $02) Then
                                msg = scplang_getphrase("items.hazmaterr7")
                                msgtimer = 350.0
                                Return $00
                            Else
                                selecteditem = arg0
                            EndIf
                        EndIf
                    Case "vest","finevest"
                        local1 = $01
                        For local5 = $00 To (maxitemamount - $01) Step $01
                            If (inventory(local5) <> Null) Then
                                If (((inventory(local5)\Field3\Field1 = "vest") Or (inventory(local5)\Field3\Field1 = "finevest")) <> 0) Then
                                    local1 = $00
                                    Exit
                                ElseIf ((((inventory(local5)\Field3\Field1 = "hazmatsuit") Or (inventory(local5)\Field3\Field1 = "hazmatsuit2")) Or (inventory(local5)\Field3\Field1 = "hazmatsuit3")) <> 0) Then
                                    local1 = $02
                                    Exit
                                EndIf
                            EndIf
                        Next
                        If (local1 = $00) Then
                            msg = scplang_getphrase("items.vesterr")
                            msgtimer = 350.0
                            Return $00
                        ElseIf (local1 = $02) Then
                            msg = scplang_getphrase("items.hazmaterr7")
                            msgtimer = 350.0
                            Return $00
                        Else
                            selecteditem = arg0
                        EndIf
                    Case "veryfinefirstaid"
                        arg0\Field13 = 0.0
                        If (0.0 < i_402\Field1) Then
                            playsound_strict(horrorsfx(rand($00, $03)))
                            msg = ((chr($22) + scplang_getphrase("items.finefirstaiderr")) + chr($22))
                            msgtimer = 420.0
                            Exit
                        EndIf
                    Case "scp178"
                        setanimtime(arg0\Field2, 19.0, $00)
                    Case "glassescase"
                        setanimtime(arg0\Field2, 19.0, $00)
                    Case "scp215"
                        setanimtime(arg0\Field2, 1.0, $00)
                    Case "key6"
                        giveachievement($39, $01)
                    Case "scp005"
                        giveachievement($25, $01)
                    Case "scp207"
                        If (0.0 < i_402\Field1) Then
                            playsound_strict(horrorsfx(rand($00, $03)))
                            msg = ((chr($22) + scplang_getphrase("items.finefirstaiderr")) + chr($22))
                            msgtimer = 420.0
                            Exit
                        Else
                            giveachievement($2B, $01)
                        EndIf
                    Case "scp198"
                        giveachievement($2A, $01)
                        msg = scplang_getphrase("items.scp198")
                        msgtimer = 420.0
                        playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\198\Shock.ogg")))
                        lightflash = 2.5
                        blurtimer = 1000.0
                        staminaeffect = min(stamina, 10.0)
                        staminaeffecttimer = 240.0
                        sanity = max(-850.0, sanity)
                        If (i_1033ru\Field0 = $00) Then
                            injuries = (injuries + 0.5)
                        Else
                            damage1033ru(((selecteddifficulty\Field3 * $05) + $1E))
                        EndIf
                    Case "scp447","minteyedrops","mintfineeyedrops","mintsupereyedrops","minteyedrops2"
                        If (0.0 < i_402\Field1) Then
                            playsound_strict(horrorsfx(rand($00, $03)))
                            msg = ((chr($22) + scplang_getphrase("items.finefirstaiderr")) + chr($22))
                            msgtimer = 420.0
                            Exit
                        EndIf
                    Case "mintveryfinefirstaid"
                        arg0\Field13 = 0.0
                        If (0.0 < i_402\Field1) Then
                            playsound_strict(horrorsfx(rand($00, $03)))
                            msg = ((chr($22) + scplang_getphrase("items.finefirstaiderr")) + chr($22))
                            msgtimer = 420.0
                            Exit
                        EndIf
                    Case "scp109"
                        setanimtime(arg0\Field2, 19.0, $00)
                        If (0.0 < i_402\Field1) Then
                            playsound_strict(horrorsfx(rand($00, $03)))
                            msg = ((chr($22) + scplang_getphrase("items.finefirstaiderr")) + chr($22))
                            msgtimer = 420.0
                            Exit
                        EndIf
                    Case "syringe","syringeinf","finesyringe","veryfinesyringe","cup","morphine","eyedrops","eyedrops2","fineeyedrops","supereyedrops"
                        If (0.0 < i_402\Field1) Then
                            playsound_strict(horrorsfx(rand($00, $03)))
                            msg = ((chr($22) + scplang_getphrase("items.finefirstaiderr")) + chr($22))
                            msgtimer = 420.0
                            Exit
                        EndIf
                    Case "scp357"
                        giveachievement($2D, $01)
                        msg = scplang_getphrase("items.scp357")
                        msgtimer = 420.0
                        i_357\Field0 = 1.0
                    Case "corrvest"
                        msg = ((chr($22) + scplang_getphrase("items.corrvesterr")) + chr($22))
                        msgtimer = 420.0
                        Exit
                End Select
                If (arg0\Field3\Field2 <> $42) Then
                    playsound_strict(picksfx(arg0\Field3\Field2))
                EndIf
                arg0\Field15 = $01
                arg0\Field16 = $FFFFFFFF
                arg0\Field3\Field3 = $01
                itemamount = (itemamount + $01)
                inventory(local0) = arg0
                hideentity(arg0\Field1)
                Exit
            EndIf
        Next
    Else
        msg = scplang_getphrase("items.pickuperr")
        msgtimer = 350.0
    EndIf
    Return $00
End Function
