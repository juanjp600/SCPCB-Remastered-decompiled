Function update409%()
    Local local0%
    Local local1#
    Local local2.fps_settings
    Local local3%
    local1 = i_409\Field0
    local2 = (First fps_settings)
    If (i_409\Field1[$00] = $00) Then
        i_409\Field1[$00] = loadsound_strict(scpmodding_processfilepath("SFX\Character\D9341\Damage10.ogg"))
    EndIf
    If (((0.0 < i_409\Field0) And (100.0 >= i_409\Field0)) <> 0) Then
        showentity(at\Field4[$0A])
        If (((i_427\Field0 = $01) And (25200.0 > i_427\Field1)) = $00) Then
            i_409\Field0 = min((i_409\Field0 + (local2\Field3[$00] * 0.004)), 100.0)
        EndIf
        entityalpha(at\Field4[$0A], min((((i_409\Field0 * 0.2) ^ 2.0) / 1000.0), 0.5))
        blurtimer = max(((i_409\Field0 * 3.0) * (2.0 - crouchstate)), blurtimer)
        If (((40.0 < i_409\Field0) And (40.0 >= local1)) <> 0) Then
            msg = scplang_getphrase("ingame.scp4091")
            msgtimer = 420.0
        ElseIf (((55.0 < i_409\Field0) And (55.0 >= local1)) <> 0) Then
            msg = scplang_getphrase("ingame.scp4092")
            msgtimer = 420.0
        ElseIf (((70.0 < i_409\Field0) And (70.0 >= local1)) <> 0) Then
            msg = scplang_getphrase("ingame.scp4093")
            msgtimer = 420.0
        ElseIf (((85.0 < i_409\Field0) And (85.0 >= local1)) <> 0) Then
            msg = scplang_getphrase("ingame.scp4094")
            msgtimer = 420.0
        ElseIf (((93.0 < i_409\Field0) And (93.0 >= local1)) <> 0) Then
            playsound_strict(i_409\Field1[$00])
            injuries = max(injuries, 2.0)
        ElseIf (94.0 < i_409\Field0) Then
            i_409\Field0 = min((i_409\Field0 + (local2\Field3[$00] * 0.004)), 100.0)
            playable = $00
            local3 = $00
            blurtimer = 4.0
            camerashake = 3.0
        EndIf
        If (96.9222 <= i_409\Field0) Then
            deathmsg = scplang_getphrase("ingame.scp4095")
            kill($01, $00)
        EndIf
    Else
        hideentity(at\Field4[$0A])
    EndIf
    Return $00
End Function
