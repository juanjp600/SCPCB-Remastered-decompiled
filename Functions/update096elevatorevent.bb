Function update096elevatorevent#(arg0.events, arg1#, arg2.doors, arg3%)
    Local local0#
    Local local1.fps_settings
    local0 = arg1
    local1 = (First fps_settings)
    If (0.0 > arg1) Then
        arg1 = 0.0
        local0 = 0.0
    EndIf
    If (((0.0 = arg2\Field7) And (arg2\Field5 = $00)) <> 0) Then
        If (((280.0 * roomscale) + (local1\Field3[$00] * 0.015)) >= (Abs (entityx(collider, $00) - entityx(arg3, $01)))) Then
            If (((280.0 * roomscale) + (local1\Field3[$00] * 0.015)) >= (Abs (entityz(collider, $00) - entityz(arg3, $01)))) Then
                If (((280.0 * roomscale) + (local1\Field3[$00] * 0.015)) >= (Abs (entityy(collider, $00) - entityy(arg3, $01)))) Then
                    arg2\Field4 = $01
                    If (0.0 = arg1) Then
                        teleportentity(curr096\Field4, entityx(arg2\Field2, $00), (entityy(arg2\Field2, $00) + 1.0), entityz(arg2\Field2, $00), curr096\Field70, $00, 2.0, $00)
                        pointentity(curr096\Field4, arg3, 0.0)
                        rotateentity(curr096\Field4, 0.0, entityyaw(curr096\Field4, $00), 0.0, $00)
                        moveentity(curr096\Field4, 0.0, 0.0, -0.5)
                        resetentity(curr096\Field4)
                        curr096\Field9 = 6.0
                        setnpcframe(curr096, 0.0)
                        arg0\Field9 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\096\ElevatorSlam.ogg"))
                        arg1 = ((local1\Field3[$00] * 1.4) + arg1)
                    EndIf
                EndIf
            EndIf
        EndIf
    EndIf
    If (0.0 < arg1) Then
        If (0.0 = local0) Then
            arg0\Field6 = playsound_strict(arg0\Field9)
        EndIf
        If (((133.0 < arg1) And (arg1 < (local1\Field3[$00] + 140.0))) <> 0) Then
            camerashake = 7.0
        ElseIf (((294.0 < arg1) And (arg1 < (local1\Field3[$00] + 297.5))) <> 0) Then
            camerashake = 1.0
        ElseIf (((413.0 < arg1) And (arg1 < (local1\Field3[$00] + 416.5))) <> 0) Then
            camerashake = 1.0
        ElseIf (((507.5 < arg1) And (arg1 < (local1\Field3[$00] + 511.0))) <> 0) Then
            camerashake = 1.0
            arg2\Field8 = $01
            arg2\Field5 = $01
            curr096\Field9 = 4.0
            curr096\Field26 = $01
        ElseIf (((567.0 < arg1) And (arg1 < (local1\Field3[$00] + 570.5))) <> 0) Then
            camerashake = 1.0
        EndIf
        If (567.0 >= arg1) Then
            arg2\Field7 = min(arg2\Field7, 20.0)
        EndIf
        arg1 = ((local1\Field3[$00] * 1.4) + arg1)
    EndIf
    Return arg1
    Return 0.0
End Function
