Function use207%()
    Local local0#
    Local local1.fps_settings
    local0 = i_207\Field0
    local1 = (First fps_settings)
    If (0.0 < i_207\Field0) Then
        If (((i_427\Field0 = $01) And (25200.0 > i_427\Field1)) = $00) Then
            i_207\Field0 = min((i_207\Field0 + (local1\Field3[$00] * 0.002)), 51.0)
        EndIf
        If (20.0 < i_207\Field0) Then
            heartbeatrate = max(heartbeatrate, (i_207\Field0 + 70.0))
            heartbeatvolume = 1.0
        EndIf
        If (((30.0 < i_207\Field0) And (30.0 >= local0)) <> 0) Then
            camerashake = 10.0
            blurtimer = 600.0
        EndIf
        If (((35.0 < i_207\Field0) And (35.0 >= local0)) <> 0) Then
            camerashake = 10.0
            blurtimer = 600.0
        EndIf
        If (50.0 <= i_207\Field0) Then
            deathmsg = scplang_getphrase("items.scp2075")
            kill($00, $00)
        EndIf
    EndIf
    Return $00
End Function
