Function use357%()
    Local local0#
    Local local1%
    Local local2.fps_settings
    Local local3%
    Local local4%
    local0 = i_357\Field0
    local2 = (First fps_settings)
    For local1 = $00 To (maxitemamount - $01) Step $01
        If (inventory(local1) <> Null) Then
            If (inventory(local1)\Field3\Field0 = "SCP-357") Then
                If (((i_427\Field0 = $01) And (25200.0 > i_427\Field1)) = $00) Then
                    i_357\Field0 = min((i_357\Field0 + (local2\Field3[$00] * 0.004)), 75.0)
                EndIf
            EndIf
        EndIf
    Next
    If (0.0 < i_357\Field0) Then
        If (((20.0 < i_357\Field0) And (20.0 >= local0)) <> 0) Then
            blurtimer = 1900.0
            local3 = (Int ((Float local3) / 2.0))
        EndIf
        If (((30.0 < i_357\Field0) And (30.0 >= local0)) <> 0) Then
            blurtimer = 3000.0
        EndIf
        If (((35.0 < i_357\Field0) And (35.0 >= local0)) <> 0) Then
            blurtimer = 4000.0
        EndIf
        If (((40.0 < i_357\Field0) And (40.0 >= local0)) <> 0) Then
            blurtimer = 5000.0
            msg = scplang_getphrase("ingame.scp3571")
            msgtimer = 420.0
        EndIf
        If (((56.0 < i_357\Field0) And (56.0 >= local0)) <> 0) Then
            blurtimer = 5000.0
            msg = scplang_getphrase("ingame.scp3572")
            msgtimer = 420.0
        EndIf
        If (65.0 < i_357\Field0) Then
            heartbeatrate = max(heartbeatrate, (i_357\Field0 + 70.0))
            heartbeatvolume = 1.0
            camerashake = (sin((i_357\Field0 / 5.0)) * (i_357\Field0 / 15.0))
        EndIf
        If (((70.0 < i_357\Field0) And (70.0 >= local0)) <> 0) Then
            blurtimer = 5600.0
            If (i_1033ru\Field0 = $00) Then
                injuries = (injuries + 2.0)
                playable = $00
                local4 = $00
            Else
                damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $32))
            EndIf
        EndIf
        If (75.0 <= i_357\Field0) Then
            If (rand($02, $01) = $01) Then
                deathmsg = (scplang_getphrase("ingame.scp3573") + " ")
            Else
                deathmsg = (scplang_getphrase("ingame.scp3574") + " ")
            EndIf
            deathmsg = (deathmsg + scplang_getphrase("ingame.scp3575"))
            kill($00, $00)
        EndIf
    EndIf
    Return $00
End Function
