Function updatemtf2%()
    Local local0.rooms
    Local local1.npcs
    Local local2%
    Local local3%
    Local local4.fps_settings
    Local local5.rooms
    Local local6.npcs
    If (((((playerroom\Field7\Field10 = "gateaentrance") Or (playerroom\Field7\Field10 = "gateb")) Or (playerroom\Field7\Field10 = "room106")) Or (playerroom\Field7\Field10 = "room457")) <> 0) Then
        Return $00
    EndIf
    local4 = (First fps_settings)
    If (0.0 = mtf2timer) Then
        If (((rand($1E, $01) = $01) And (playerroom\Field7\Field10 <> "dimension1499")) <> 0) Then
            local5 = Null
            For local0 = Each rooms
                If (lower(local0\Field7\Field10) = "gateb") Then
                    local5 = local0
                    Exit
                EndIf
            Next
            If (local5 <> Null) Then
                If (30.0 > (Abs (entityz(local5\Field2, $00) - entityz(collider, $00)))) Then
                    mtf2timer = 1.0
                    For local3 = $00 To $02 Step $01
                        local1 = createnpc($1C, (entityx(local5\Field2, $00) + (0.3 * (Float (local3 - $01)))), 1.0, (entityz(local5\Field2, $00) + 8.0))
                        If (local3 = $00) Then
                            local6 = local1
                        Else
                            local1\Field77 = local6
                        EndIf
                        local1\Field28 = (Float local3)
                    Next
                EndIf
            EndIf
        EndIf
    EndIf
    Return $00
End Function
