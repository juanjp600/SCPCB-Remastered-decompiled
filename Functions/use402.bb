Function use402%()
    Local local0#
    Local local1.fps_settings
    Local local2%
    local0 = i_402\Field1
    local1 = (First fps_settings)
    If (i_402\Field0 > $00) Then
        If (0.0 <= i_402\Field1) Then
            i_402\Field1 = min((i_402\Field1 + (local1\Field3[$00] * 0.004)), 61.0)
            If (((10.0 < i_402\Field1) And (10.0 >= local0)) <> 0) Then
                playsound_strict(coughsfx(rand($00, $02)))
                camerashake = 5.0
                If (i_1033ru\Field0 = $00) Then
                    msg = scplang_getphrase("ingame.scp4024")
                    injuries = (injuries + 0.1)
                Else
                    msg = scplang_getphrase("ingame.scp4025")
                    damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0A))
                EndIf
                msgtimer = 420.0
            EndIf
            If (((15.0 < i_402\Field1) And (15.0 >= local0)) <> 0) Then
                msg = scplang_getphrase("ingame.scp4026")
                msgtimer = 420.0
            EndIf
            If (i_1033ru\Field0 > $00) Then
                If (12.0 < i_402\Field1) Then
                    msg = scplang_getphrase("ingame.scp4027")
                    msgtimer = 420.0
                    damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0A))
                    playsound_strict(coughsfx(rand($00, $02)))
                    i_402\Field0 = $00
                EndIf
            EndIf
            If (((20.0 < i_402\Field1) And (20.0 >= local0)) <> 0) Then
                msg = scplang_getphrase("ingame.scp4028")
                msgtimer = 420.0
                camerashake = 5.0
                injuries = (injuries + 0.1)
                local2 = (Int ((Float local2) / 0.5))
            EndIf
            If (((40.0 < i_402\Field1) And (40.0 >= local0)) <> 0) Then
                msg = scplang_getphrase("ingame.scp4029")
                msgtimer = 420.0
                playsound_strict(coughsfx(rand($00, $02)))
                camerashake = 5.0
                injuries = (injuries + 0.1)
            EndIf
            If (42.0 < i_402\Field1) Then
                heartbeatrate = max(heartbeatrate, (i_402\Field1 + 70.0))
                heartbeatvolume = 1.0
            EndIf
            If (((45.0 < i_402\Field1) And (45.0 >= local0)) <> 0) Then
                playsound_strict(coughsfx(rand($00, $02)))
            EndIf
            If (((50.0 < i_402\Field1) And (50.0 >= local0)) <> 0) Then
                msg = ((chr($22) + scplang_getphrase("ingame.scp40210")) + chr($22))
                msgtimer = 420.0
                playsound_strict(coughsfx(rand($00, $02)))
            EndIf
            If (((55.0 < i_402\Field1) And (55.0 >= local0)) <> 0) Then
                playsound_strict(coughsfx(rand($00, $02)))
            EndIf
            If (((60.0 <= i_402\Field1) And (60.0 >= local0)) <> 0) Then
                playsound_strict(coughsfx(rand($00, $02)))
                deathmsg = scplang_getphrase("ingame.scp40211")
                kill($00, $00)
            EndIf
        EndIf
    Else
        i_402\Field1 = 0.0
    EndIf
    Return $00
End Function
