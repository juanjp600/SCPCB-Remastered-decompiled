Function updateachievementmsg%()
    Local local0.fps_settings
    Local local1.achievementmsg
    Local local2%
    Local local3#
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    local0 = (First fps_settings)
    local3 = ((Float graphicheight) / 768.0)
    local4 = (Int (264.0 * local3))
    local5 = (Int (84.0 * local3))
    For local1 = Each achievementmsg
        If (0.0 <> local1\Field3) Then
            If (((0.0 < local1\Field3) And (490.0 > local1\Field3)) <> 0) Then
                local1\Field3 = (local1\Field3 + local0\Field3[$01])
                If ((Float (- local4)) < local1\Field2) Then
                    local1\Field2 = max((local1\Field2 - (local0\Field3[$01] * 4.0)), (Float (- local4)))
                EndIf
            ElseIf (490.0 <= local1\Field3) Then
                local1\Field3 = -1.0
            ElseIf (-1.0 = local1\Field3) Then
                If (0.0 > local1\Field2) Then
                    local1\Field2 = min((local1\Field2 + (local0\Field3[$01] * 4.0)), 0.0)
                Else
                    local1\Field3 = 0.0
                EndIf
            EndIf
        Else
            Delete local1
        EndIf
    Next
    Return $00
End Function
