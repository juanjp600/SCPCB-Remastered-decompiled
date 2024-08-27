Function use215%()
    Local local0#
    Local local1.fps_settings
    Local local2%
    local0 = i_215\Field1
    local1 = (First fps_settings)
    If (((((i_215\Field0 = $01) And ((i_714\Field0 = $01) = $00)) And ((wearinggasmask = $03) = $00)) And ((wearinghazmat = $03) = $00)) <> 0) Then
        If (0.0 <= i_215\Field2) Then
            i_215\Field2 = min((i_215\Field2 + (local1\Field3[$00] * 0.002)), 10.0)
        EndIf
        If (10.0 <= i_215\Field2) Then
            i_215\Field1 = 1.0
        EndIf
    Else
        i_215\Field2 = 0.0
    EndIf
    If (i_215\Field3[$00] = $00) Then
        i_215\Field3[$00] = loadsound_strict(scpmodding_processfilepath("SFX\SCP\215\Whisper.ogg"))
    EndIf
    If (0.0 < i_215\Field1) Then
        shouldplay = $1E
        showentity(at\Field4[$0C])
        If (((((i_714\Field0 = $01) = $00) And ((wearinggasmask = $03) = $00)) And ((wearinghazmat = $03) = $00)) <> 0) Then
            i_215\Field1 = min((i_215\Field1 + (local1\Field3[$00] * 0.004)), 146.0)
        EndIf
        If (1.0 <= i_215\Field1) Then
            i_215\Field2 = 0.0
        EndIf
        If (100.0 >= i_215\Field1) Then
            entityalpha(at\Field4[$0C], min((((i_215\Field1 * 0.2) ^ 2.0) / 1000.0), 0.5))
            blurtimer = max(((i_215\Field1 * 3.0) * (2.0 - crouchstate)), blurtimer)
        EndIf
        If (((20.0 < i_215\Field1) And (20.0 >= local0)) <> 0) Then
            blurtimer = 1900.0
        EndIf
        If (((30.0 < i_215\Field1) And (30.0 >= local0)) <> 0) Then
            blurtimer = 3000.0
            msg = scplang_getphrase("ingame.scp2159")
            msgtimer = 420.0
        EndIf
        If (((35.0 < i_215\Field1) And (35.0 >= local0)) <> 0) Then
            blurtimer = 4000.0
        EndIf
        If (((40.0 < i_215\Field1) And (40.0 >= local0)) <> 0) Then
            blurtimer = 5000.0
            msg = scplang_getphrase("ingame.scp21510")
            msgtimer = 420.0
            playsound_strict(i_215\Field3[$00])
        EndIf
        If (((45.0 < i_215\Field1) And (45.0 >= local0)) <> 0) Then
            msg = ((chr($22) + scplang_getphrase("ingame.scp21511")) + chr($22))
            msgtimer = 420.0
        EndIf
        If (55.0 < i_215\Field1) Then
            heartbeatrate = max(heartbeatrate, (i_215\Field1 + 70.0))
            heartbeatvolume = 1.0
        EndIf
        If (((60.0 < i_215\Field1) And (60.0 >= local0)) <> 0) Then
            msg = ((chr($22) + scplang_getphrase("ingame.scp21512")) + chr($22))
            msgtimer = 420.0
        EndIf
        If (((65.0 < i_215\Field1) And (65.0 >= local0)) <> 0) Then
            msg = ((chr($22) + scplang_getphrase("ingame.scp21513")) + chr($22))
            msgtimer = 420.0
        EndIf
        If (((70.0 < i_215\Field1) And (70.0 >= local0)) <> 0) Then
            blurtimer = 5200.0
            camerashake = 22.0
            msg = scplang_getphrase("ingame.scp21514")
            msgtimer = 420.0
            playsound_strict(i_215\Field3[$00])
        EndIf
        If (((75.0 < i_215\Field1) And (75.0 >= local0)) <> 0) Then
            camerashake = 30.0
            msg = ((chr($22) + scplang_getphrase("ingame.scp21515")) + chr($22))
            msgtimer = 420.0
        EndIf
        If (((86.0 < i_215\Field1) And (86.0 >= local0)) <> 0) Then
            blurtimer = 5300.0
            camerashake = 7.0
            playsound_strict(i_215\Field3[$00])
            For local2 = $00 To (maxitemamount - $01) Step $01
                If (inventory(local2) <> Null) Then
                    If (inventory(local2)\Field3\Field0 = "SCP-215") Then
                        msg = scplang_getphrase("ingame.scp21516")
                        msgtimer = 420.0
                        If (((((wearinggasmask Or i_1499\Field0) Or wearinghazmat) Or wearingnightvision) Or i_178\Field0) <> 0) Then
                            i_215\Field0 = $01
                            wearinggasmask = $00
                            i_1499\Field0 = $00
                            wearinghazmat = $00
                            wearingnightvision = $00
                            i_178\Field0 = $00
                        EndIf
                        Exit
                    EndIf
                EndIf
            Next
        EndIf
        If (((90.0 < i_215\Field1) And (90.0 >= local0)) <> 0) Then
            camerashake = 50.0
            msg = scplang_getphrase("ingame.scp21517")
            msgtimer = 420.0
        EndIf
        If (((94.0 < i_215\Field1) And (94.0 >= local0)) <> 0) Then
            camerashake = 50.0
            msg = ((chr($22) + scplang_getphrase("ingame.scp21518")) + chr($22))
            msgtimer = 420.0
        EndIf
        If (((96.0 < i_215\Field1) And (96.0 >= local0)) <> 0) Then
            blurtimer = 7000.0
            camerashake = 50.0
            msg = ((chr($22) + scplang_getphrase("ingame.scp21519")) + chr($22))
            msgtimer = 420.0
        EndIf
        If (((110.0 < i_215\Field1) And (110.0 >= local0)) <> 0) Then
            blurtimer = 8000.0
            camerashake = 50.0
            msg = ((chr($22) + scplang_getphrase("ingame.scp21520")) + chr($22))
            msgtimer = 420.0
        EndIf
        If (((135.0 < i_215\Field1) And (135.0 >= local0)) <> 0) Then
            blurtimer = 8000.0
            camerashake = 50.0
            msg = ((chr($22) + scplang_getphrase("ingame.scp21521")) + chr($22))
            msgtimer = 420.0
        EndIf
        If (((146.0 < i_215\Field1) And (146.0 >= local0)) <> 0) Then
            blurtimer = 9000.0
            camerashake = 100.0
            msg = ((chr($22) + scplang_getphrase("ingame.scp21522")) + chr($22))
            msgtimer = 420.0
        EndIf
    Else
        hideentity(at\Field4[$0C])
    EndIf
    Return $00
End Function
