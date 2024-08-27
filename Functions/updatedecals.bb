Function updatedecals%()
    Local local0.decals
    Local local1.fps_settings
    Local local2%
    Local local3#
    Local local4#
    Local local5.decals
    local1 = (First fps_settings)
    For local0 = Each decals
        If (0.0 <> local0\Field1) Then
            local0\Field2 = ((local0\Field1 * local1\Field3[$00]) + local0\Field2)
            scalesprite(local0\Field0, local0\Field2, local0\Field2)
            local2 = local0\Field8
            If (local2 = $00) Then
                If (0.0 >= local0\Field9) Then
                    local3 = (Float rand($168, $01))
                    local4 = rnd(local0\Field2, 0.0)
                    local5 = createdecal($01, (entityx(local0\Field0, $00) + (cos(local3) * local4)), (entityy(local0\Field0, $00) - 0.0005), (entityz(local0\Field0, $00) + (sin(local3) * local4)), entitypitch(local0\Field0, $00), rnd(360.0, 0.0), entityroll(local0\Field0, $00))
                    local5\Field2 = rnd(0.1, 0.5)
                    scalesprite(local5\Field0, local5\Field2, local5\Field2)
                    playsound2(decaysfx(rand($01, $03)), camera, local5\Field0, 10.0, rnd(0.1, 0.5))
                    local0\Field9 = (Float rand($32, $64))
                Else
                    local0\Field9 = (local0\Field9 - local1\Field3[$00])
                EndIf
            EndIf
            If (local0\Field3 <= local0\Field2) Then
                local0\Field1 = 0.0
                local0\Field2 = local0\Field3
            EndIf
        EndIf
        If (0.0 <> local0\Field4) Then
            local0\Field5 = min(((local1\Field3[$00] * local0\Field4) + local0\Field5), 1.0)
            entityalpha(local0\Field0, local0\Field5)
        EndIf
        If (0.0 < local0\Field10) Then
            local0\Field10 = max((local0\Field10 - local1\Field3[$00]), 5.0)
        EndIf
        If ((((0.0 >= local0\Field2) Or (0.0 >= local0\Field5)) Or (5.0 = local0\Field10)) <> 0) Then
            freeentity(local0\Field0)
            Delete local0
        EndIf
    Next
    Return $00
End Function
